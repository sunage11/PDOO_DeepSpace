
module DeepSpace

# 9.3.17 - Translation from Java
# @author Profe

class LootToUI
  attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals

  def initialize(l)
    @nSupplies=l.nSupplies
    @nWeapons=l.nWeapons
    @nShields=l.nShields
    @nHangars=l.nHangars
    @nMedals=l.nMedals
  end

  def to_s
    return "Supplies: #{@nSupplies}, Weapons: #{@nWeapons}, Shields: #{@nShields}, Hangars: #{@nHangars}, Medals: #{@nMedals}"
  end

end # class

end # module
