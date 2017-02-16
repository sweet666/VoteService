package by.safronenko.voteservice.dao;

import java.util.List;

import by.safronenko.voteservice.entities.Vote;

/**
 * DAO interface for Vote entity
 */
public interface VoteDAO {

	void addVote(Vote contact);

	List<Vote> listVote();

	void removeVote(String id);

	void closeVote(String id);

	Vote getVote(String id);

	void FirstCounterIncrementer(String id);

	void SecondCounterIncrementer(String id);
}