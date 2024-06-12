package game.gts;

import game.utils.templates.FluidTemplate;

/**
 * 
 */

public class Fluid extends Item {

    public String Color;
    public Material[] Component;
    public Element[] Elements;
    public long Temperature;
    public String ChemFormula;

    public void loadChemFormula() {
        if (this.Component == null) {
            for (Element e : this.Elements) {
                this.ChemFormula += e.ChemSymbol + Element.ChemNumbers[e.Amount.intValue()];
            }
        } else {
            for (Material m : this.Component) {
                this.ChemFormula += String.format("(%s%c)", m.Name, Element.ChemNumbers[m.Amount.intValue()]);
            }
        }
    }

    public static Fluid valueOf(FluidTemplate FF) {
        Fluid tmp = new Fluid();
        tmp.Name = FF.Name;
        tmp.Description = FF.Description;
        tmp.Flags = FF.Flags;
        tmp.FlagSettings = FF.FlagSettings;

        tmp.Color = FF.Color;
        tmp.Temperature = FF.Temperature;

        if (FF.Component == null) {
            tmp.Component = FF.Component;
        } else {
            tmp.Elements = FF.Elements;
        }

        return tmp;
    }

}
