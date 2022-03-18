# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# WeaponType
# It represents the types of weapons

module DeepSpace
    module WeaponType
        
        class Type 

            # Constructor
            def initialize (p, n)
                @power=p
                @name=n
            end

            # Getter
            def power
                @power
            end

            # To string
            def to_s
                return "#{@name}"
            end
        end
        
        LASER   = Type.new(2.0, "LASER")
        MISSILE = Type.new(3.0, "MISSILE")
        PLASMA  = Type.new(4.0, "PLASMA")

    end
end