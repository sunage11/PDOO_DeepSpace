
 # BOLÍVAR PELÁEZ, CLARA
 # RUIZ GÓMEZ, SOLEDAD
 # 2º DGIIM - PDOO - Práctica 1 DeepSpace
 
 #Representa a los potenciadores de escudo que pueden tener las estaciones espaciales.

 module DeepSpace
    class Weapon 
        
        #Constructor que inicializa los atributos

        def initialize (n, t, u)
            @name= n
            @type= t
            @uses= u 
        end

        #Constructor de copia (es un método de clase)

        def self.newCopy (s)
            new(s.name, s.type, s.uses)
        end

        #Consultor para el atributo name

        def name
            @name
        end 

        #Consultor para el atributo type

        def type 
            @type
        end

        #Consultor para el atributo uses

        def uses 
            @uses
        end
        
        #Método de instancia pública que devuelve la potencia de diapro indicada por el tipo de arma.

        def power
            type.power() #DUDAAAAA¿¿??
        end  
        
        #Método de instancia pública sin parámetros.

        def useIt
            if(uses>0)
                @uses -= 1
                power()
            else
                1.0
            end
        end
    end
 end