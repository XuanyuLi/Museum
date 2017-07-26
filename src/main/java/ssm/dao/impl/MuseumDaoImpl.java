package ssm.dao.impl;

import ssm.model.Museum;
import ssm.dao.MuseumDao;

import org.springframework.stereotype.Repository;

@Repository
public class MuseumDaoImpl extends GenericDaoImpl<Museum, Integer> implements MuseumDao {
}