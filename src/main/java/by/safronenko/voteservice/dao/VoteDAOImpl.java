package by.safronenko.voteservice.dao;

import java.util.List;
import java.util.UUID;

import by.safronenko.voteservice.entities.Vote;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of VoteDAO interface
 */
@Repository
public class VoteDAOImpl implements VoteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	//Добавление нового голосования
	public void addVote(Vote vote) {
		//Генерируем значение id, link, is_open, устанавливаем счетчики голосов равные 0
		String uuid = UUID.randomUUID().toString();
		vote.setId(uuid);
		vote.setLink("localhost:8080/vote/"+uuid);
		vote.setIs_open("open");
		vote.setFirst_counter(0);
		vote.setSecond_counter(0);
		sessionFactory.getCurrentSession().save(vote);
	}

	//Получение списка всех голосований
	@SuppressWarnings("unchecked")
	public List<Vote> listVote() {

		return sessionFactory.getCurrentSession().createQuery("from Vote")
			.list();
	}

	//Удаление голосования
	public void removeVote(String id) {
		Vote vote = (Vote) sessionFactory.getCurrentSession().load(
				Vote.class, id);
		if (null != vote) {
			sessionFactory.getCurrentSession().delete(vote);
		}

	}

	// Устанавливает значение "close" переменной is_open,
	//закрывая голосование
	public void closeVote(String id) {
		Vote vote = (Vote) sessionFactory.getCurrentSession().load(
				Vote.class, id);
		if (null != vote) {
			String st = "close";
			vote.setIs_open(st);
			sessionFactory.getCurrentSession().update(vote);
		}
	}

	//Получает голосование по id
	public Vote getVote(String id) {

		Vote vote = (Vote) sessionFactory.getCurrentSession().get(Vote.class, id);

		return vote;
	}

	//Метод получает голосование по id и инкрементирует переменную "first_counter"
	public void FirstCounterIncrementer(String id){
		Vote vote = (Vote) sessionFactory.getCurrentSession().get(Vote.class, id);
		int counter = vote.getFirst_counter();
		vote.setFirst_counter(counter+1);
		sessionFactory.getCurrentSession().update(vote);
	}

	//Метод получает голосование по id и инкрементирует переменную "second_counter"
	public void SecondCounterIncrementer(String id){
		Vote vote = (Vote) sessionFactory.getCurrentSession().get(Vote.class, id);
		int counter = vote.getSecond_counter();
		vote.setSecond_counter(counter+1);
		sessionFactory.getCurrentSession().update(vote);
	}


}
