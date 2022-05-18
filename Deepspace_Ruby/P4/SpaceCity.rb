# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 4 DeepSpace

# SpaceCity
# 

module Deepspace

    class SpaceCity < SpaceStation

        attr_reader :collaborators
        
        # Constructores
        def initialize (b, c)
            newCopy(b)
            @base = b
            @collaborators = c
        end

        # fire
        def fire 
            output = @base.fire 

            collaborators.each do |coll|
                output += coll.fire
            end

            return output
        end

        # protection
        def protection 
            output = @base.protection 

            collaborators.each do |coll|
                output += coll.protection
            end

            return output
        end

        # setLoot
        def setLoot (loot)
            super
            return Transformation::NOTRANSFORM
        end

        # ToUI
        # builds a new SpaceCityToUI object from self
        def getUIversion
            SpaceCityToUI.new(self)
        end

        # to_s
        def to_s
            return getUIversion().to_s
        end



    end
end
