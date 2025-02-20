# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# Loot
# It represents the loot that a station can get if it beats an enemy starship

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
        end

end