package net.rahli.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.rahli.dao.IDao;

@Service("metier")
public class MetierImpl implements IMetier {
    private IDao dao; // Couplage faible

    /**
     * Pour injecter dans l'attribut dao
     * un objet d'une classe qui implémente l'interface IDO
     * au moment de l'instantiation
     */
    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 12 * Math.PI / 2 * Math.cos(t);
        return res;
    }

    /**
     * Pour injecter dans l'attribut dao
     * un objet d'une classe qui implémente l'interface IDO
     * après instantiation
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
