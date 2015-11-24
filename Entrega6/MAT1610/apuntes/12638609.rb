require 'Prime'
require 'OpenSSL'

def genkeys
  f1 = File.exist?('12638609_pub.rsa')
  f2 = File.exist?('12638609_priv.rsa')
  f3 = File.exist?('12638609_genkey_details.txt')
  if f1==false or f2==false or f3==false
    f1 = File.open('12638609_pub.rsa', 'w')
    f2 = File.open('12638609_priv.rsa', 'w')
    f3 = File.open('12638609_genkey_details.txt', 'w')
    p=OpenSSL::BN::generate_prime(768)
    q=OpenSSL::BN::generate_prime(768)
    while q==p
      q=OpenSSL::BN::generate_prime(768)
    end
    n=p*q
    m=(p-1)*(q-1)
    e=65537
    while e.to_i.gcd(m.to_i)!=1
      p=OpenSSL::BN::generate_prime(768)
      q=OpenSSL::BN::generate_prime(768)
      while q==p
        q=OpenSSL::BN::generate_prime(768)
      end
      n=p*q
      m=(p-1)*(q-1)
    end
    k=1
    while (k*m+1).remainder(e)!=0
      k+=1
    end
    d=(k*m+1)/e
    f1.puts(e,n)
    f2.puts(d,n)
    f3.puts(p,q,n,m,e,d)
    f1.close
    f2.close
    f3.close
  end
end

def self.mod_pow(base, power, mod) #http://www.lukaszielinski.de/blog/posts/2013/07/04/the-rsa-algorithm-in-ruby/
  res = 1
  while power > 0
    res = (res * base) % mod if power & 1 == 1
    base = base ** 2 % mod
    power >>= 1
  end
  res
end

def encrypt
  f1 = File.open('ext_pub.rsa', 'r')
  e=f1.gets
  n=f1.gets
  f1.close
  f2 = File.open('ext_plaintext.txt', 'r')
  f3 = File.open('12638609_ciphertext.txt', 'w')
  f2.each_byte do |c|
    f3.print(mod_pow(c,e.to_i,n.to_i))
    f3.print(" ")
  end
  f2.close
  f3.close
end

def decrypt
  f1 = File.open('12638609_priv.rsa', 'r')
  d=f1.gets
  n=f1.gets
  f1.close
  f2 = File.open('ext_ciphertext.txt', 'r')
  f3 = File.open('12638609_plaintext.txt', 'w')
  f2.read.split.each do |p|
    f3.print(mod_pow(p.to_i,d.to_i,n.to_i).chr)
  end
  f2.close
  f3.close
end

def run(ins)
  if ins=='genkeys'
    genkeys
  end
  if ins=='encrypt'
    encrypt
  end
  if ins=='decrypt'
    decrypt
  end
end

run(ARGV[0])