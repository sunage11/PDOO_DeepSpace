# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 4 DeepSpace

# Loot
# It represents the loot that a station can get if it beats an enemy starship


require_relative 'LootToUI'

module Deepspace

        class Loot 

            attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals, :efficient, :spaceCity

            # Constructor
            def initialize (s, w, sh, h, m, g=false, sc=false)
                @nSupplies  = s
                @nWeapons   = w 
                @nShields   = sh 
                @nHangars   = h
                @nMedals    = m 
                @getEfficient = g
                @spaceCity = sc
            end

            #Copy constructor 
            def self.newCopy (e)
                @nSupplies  = e.nSupplies
                @nWeapons   = e.nWeapons
                @nShields   = e.nShields
                @nHangars   = e.nHangars
                @nMedals    = e.nMedals 
            end

            # builds a new LootToUI object from self
            def getUIversion
                LootToUI.new(self)
            end

            #toString
            def to_s
                return getUIversion().to_s
            end
        end

end