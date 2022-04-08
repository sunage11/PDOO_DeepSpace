# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

require_relative 'GameCharacter'

# Dice
# It takes all random decisions in the game, based on a set of probabilities

module Deepspace

    class Dice 

        # Constructor
        def initialize
            @NHANGARSPROB  = 0.25
            @NSHIELDSPROB  = 0.25
            @NWEAPONSPROB  = 0.33
            @FIRSTSHOTPROB = 0.5

            @generator     = Random.new();
        end

        # Determines how many hangars a spacial station will receive
        def initWithNHangars
            if (@generator.rand() < @NHANGARSPROB)
                0
            else
                1
            end
        end

        # Determines how many weapons a spacial station will receive
        def initWithNWeapons

            probability = @generator.rand()

            if (probability < @NWEAPONSPROB)
                1
            else
                if (probability < 2*@NWEAPONSPROB)
                    3
                else
                    2
                end
            end
        end

        # Determines how many shield boosters a spacial station will receive 
        def initWithNShields
            if (@generator.rand() < @NSHIELDSPROB)
                0
            else
                1
            end
        end

        # Determines the player who shall start playing
        def whoStarts (nPlayers)
            
            @generator.rand(nPlayers)   #returns a random integer between 0 and nPlayers
        end

        # Determines whether a spacial station or an enemy starship starts
        # shooting when a combat takes place. It uses FIRSTSHOTPROB to determine this
        def firstShot
            if (@generator.rand() < @FIRSTSHOTPROB)
                GameCharacter::SPACESTATION
            else
                GameCharacter::ENEMYSTARSHIP
            end
        end

        # Determines whether a spacial station will escape to avoid a shot or
        # not. The probability of this move will be greater as the spacial station's 
        # potential speed is.
         def spaceStationMoves (speed)
            if (@generator.rand() < speed)
                true
            else
                false
            end
        end



    end

end