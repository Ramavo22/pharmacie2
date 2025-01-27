package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.entity.Client;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class ClientService {

    public static List<Client> findAll() {
        EntityManager em = JPAUtils.getEntityManager();
        List<Client> clients = em.createQuery("select c from Client c", Client.class).getResultList();
        if(em.isOpen()) em.close();
        return clients;
    }
}
