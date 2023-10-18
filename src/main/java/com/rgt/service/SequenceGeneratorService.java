package com.rgt.service;

public interface SequenceGeneratorService {
	
	 //public void SequenceGeneratorServiceImpl(MongoOperations mongoOperations) 


	long generateSequence(String seqName);
}
