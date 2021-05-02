package Klasser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DeltagerEAO {

    public DeltagerEAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("deltagerPU");

        em = emf.createEntityManager();
    }

    @PersistenceContext(name = "deltagerPU")
    private EntityManager em;

    public void leggTilDeltager(Deltager deltager){
        em.persist(deltager);
    }

    public Deltager getDeltager(String tlf){
        Deltager deltager = em.find(Deltager.class, tlf);
        return deltager;
    }

    public List<Deltager> getDeltagere(){
        List<Deltager> deltagere = em.createQuery("SELECT d from Deltager d").getResultList();
        return deltagere;
    }
}
