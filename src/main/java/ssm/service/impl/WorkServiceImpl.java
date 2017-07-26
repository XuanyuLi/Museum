package ssm.service.impl;

import ssm.model.Work;
import ssm.service.WorkService;
import ssm.dao.GenericDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class WorkServiceImpl extends GenericServiceImpl<Work, Integer> implements WorkService {

    @Override
    @Autowired
    @Qualifier("workDaoImpl")
    void setGenericDao(GenericDao<Work, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}