
package com.hrdb.service;
// Generated 7 Oct, 2014 3:41:51 PM 

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

public interface QueryExecutorService {

	
	Page<Object> executeWMCustomQuerySelect(CustomQuery query, Pageable pageable) ;

	int executeWMCustomQueryUpdate(CustomQuery query) ;
}

