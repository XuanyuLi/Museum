package ssm.dao.impl;

import ssm.model.Work;
import ssm.dao.WorkDao;

import org.springframework.stereotype.Repository;

@Repository
public class WorkDaoImpl extends GenericDaoImpl<Work, Integer> implements WorkDao {
}