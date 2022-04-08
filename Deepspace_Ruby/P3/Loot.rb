# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# Loot
# It represents the loot that a station can get if it beats an enemy starship


require_relative 'LootToUI'

module DeepSpace

        class Loot 

            # Constructor
            def initialize (s, w, sh, h, m)
                @nSupplies  = s
                @nWeapons   = w 
                @nShields   = sh 
                @nHangars   = h
                @nMedals    = m 
            end

            #Copy constructor 
            def self.newCopy (e)
                @nSupplies  = e.nSupplies
                @nWeapons   = e.nWeapons
                @nShields   = e.nShields
                @nHangars   = e.nHangars
                @nMedals    = e.nMedals 
            end
            
            # Getters
            def nSupplies
                @nSupplies
            end

            def nWeapons
                @nWeapons
            end

            def nShields
                @nShields
            end

            def nHangars
                @nHangars
            end

            def nMedals
                @nMedals
            end

            # builds a new LootToUI object from self
            def getUIversion
                LootToUI.new(self)
            end

            #toString
            def to_s
                output = "Loot [ nSupplies #{@nSupplies} ; " +
                         "nWeapons #{@nWeapons} ; " +
                         "nShields  #{@nShields} ; " +
                         "nHangars  #{@nHangars} ; " +
                         "nMedals  #{@nMedals} ]"
            end
        end

end