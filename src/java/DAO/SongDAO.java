package DAO;

import Songs.Mp3;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository// oi klaseis pou kanoun kati sti vasi
public class SongDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional //oi methodoi pou kanoun kati stin vasi
    public void insert(Mp3 mp3) {
        em.merge(mp3);
        //   em.persist(mp3);
    }
    //oi methodoi pou kanoun kati stin vasi

    @Transactional
    public List<Mp3> finder(String txt) {
        List<Mp3> k;
        Query q = em.createQuery("Select a from Mp3 a where a.title like:name", Mp3.class);
        q.setParameter("name", txt + "%");
        System.out.println(q);
        System.out.println(txt);
        k = q.getResultList();
        return k;

        //   em.persist(mp3);
    }

}
//query pou pairnei ta gramata pou grafw
