package com.github.llres.springl.transactionCase;

import com.github.llres.springl.pojo.Pojo1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2Repository extends CrudRepository<Pojo1,Long>{
}
