package sample.domain.Forms;

/**
 * Created by marek on 10.12.16.
 */
public class DayDeclarationForm {

    private DeclarationForm declarations [][] = new DeclarationForm [3][1];

    public DayDeclarationForm() {

    }

    public DeclarationForm[][] getDeclarations() {
        return declarations;
    }

    public void setDeclarations(DeclarationForm[][] declarations) {
        this.declarations = declarations;
    }

}
