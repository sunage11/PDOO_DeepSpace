class Examen1
    def initialize (a=44, b=33)
        @a =2*a
        @b=b-2
    end

    def salida
        return 2*(@a+@b)
    end

end

class Hija<Examen1
    def initialize (c)
        @c=c
    end
end

puts Hija.new(77).salida