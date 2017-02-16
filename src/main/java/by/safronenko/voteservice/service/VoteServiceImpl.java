package by.safronenko.voteservice.service;
 
import java.util.List;

import by.safronenko.voteservice.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import by.safronenko.voteservice.dao.VoteDAO;

/**
 * Implementation of VoteService interface
 */
@Service
public class VoteServiceImpl implements VoteService {
 
    @Autowired
    private VoteDAO voteDAO;
 
    @Transactional
    public void addVote(Vote vote) {
        voteDAO.addVote(vote);
    }
 
    @Transactional
    public List<Vote> listVote() {
 
        return voteDAO.listVote();
    }
 
    @Transactional
    public void removeVote(String id) {
        voteDAO.removeVote(id);
    }

    @Transactional
    public void closeVote(String id) {
        voteDAO.closeVote(id);
    }

    @Transactional
    public Vote getVote(String id) {
        return voteDAO.getVote(id);
    }

    @Transactional
    public void firstCounterIncrementer(String id){
        voteDAO.FirstCounterIncrementer(id);
    }

    @Transactional
    public void secondCounterIncrementer(String id){
        voteDAO.SecondCounterIncrementer(id);
    }
}
