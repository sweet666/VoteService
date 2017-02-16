package by.safronenko.voteservice.service;

import java.util.List;
import by.safronenko.voteservice.entities.Vote;

/**
 * Service interface for Vote entity
 */
public interface VoteService {

	void addVote(Vote contact);

	List<Vote> listVote();

	void removeVote(String id);

	void closeVote(String id);

	Vote getVote(String id);

	void firstCounterIncrementer(String id);

	void secondCounterIncrementer(String id);
}
