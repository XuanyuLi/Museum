package ssm.service.impl;

import ssm.model.Museum;
import ssm.service.MuseumService;
import ssm.dao.GenericDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class MuseumServiceImpl extends GenericServiceImpl<Museum, Integer> implements MuseumService {

    @Override
    @Autowired
    @Qualifier("museumDaoImpl")
    void setGenericDao(GenericDao<Museum, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}