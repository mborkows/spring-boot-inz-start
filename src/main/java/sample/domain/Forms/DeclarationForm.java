package sample.domain.Forms;

import sample.domain.Declaration;

/**
 * Created by marek on 10.12.16.
 */
public class DeclarationForm {

    private Declaration declaration;
    private Boolean isAccepted;

    public DeclarationForm(){

    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

}
