package by.safronenko.voteservice.web;

import java.util.Map;

import by.safronenko.voteservice.entities.Vote;
import by.safronenko.voteservice.service.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Main controller
 */
@Controller
public class VoteController {

	@Autowired
	private VoteService voteService;

	//Возвращает vote.jsp с коллекцией всех голосований
	@RequestMapping("/vote")
	public String listVotes(Map<String, Object> map) {

		map.put("vote", new Vote());
		map.put("voteList", voteService.listVote());

		return "vote";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/vote";
	}

	//Добавление нового голосования
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addVote(@ModelAttribute("vote") Vote vote,
			BindingResult result) {

		voteService.addVote(vote);

		return "redirect:/vote";
	}

	//Удаление голосования по id
	@RequestMapping("/delete/{voteId}")
	public String deleteVote(@PathVariable("voteId") String voteId) {

		voteService.removeVote(voteId);

		return "redirect:/vote";
	}

	//Для выбранного голосования устанавливает значение "closed" для параметра "is_open"
	@RequestMapping("/close/{voteId}")
	public String closeVote(@PathVariable("voteId") String voteId) {

		voteService.closeVote(voteId);

		return "redirect:/vote";
	}

	//Метод вызывается при переходе по ссылке для голосования
	//Возвращает answer.jsp с голосованием
	@RequestMapping(value = "/vote/{voteId}", method = RequestMethod.GET)
	public String getVote(@PathVariable("voteId") String voteId, Model model) {

		model.addAttribute("vote", voteService.getVote(voteId));

		return "answer";
	}

	//Добавление голоса в голосование
	//Метод получает значение голосов из БД и инкрементирует его
	@RequestMapping("/1/{voteId}")
	public String firstCounterIncrementer(@PathVariable("voteId") String voteId, Model model) {

		Vote vote = voteService.getVote(voteId);

		// Если голосование закрыто - возвращает пользователю jsp с ошибкой
		if (vote.getIs_open().equals("open")){
			voteService.firstCounterIncrementer(voteId);
			model.addAttribute("vote", voteService.getVote(voteId));
			return "answer";
		}

		else return "voteClosedError";
	}

	//Добавление голоса в голосование
	//Метод получает значение голосов из БД и инкрементирует его
	@RequestMapping("/2/{voteId}")
	public String secondCounterIncrementer(@PathVariable("voteId") String voteId, Model model) {

		Vote vote = voteService.getVote(voteId);

		// Если голосование закрыто - возвращает пользователю jsp с ошибкой
		if (vote.getIs_open().equals("open")){
			voteService.secondCounterIncrementer(voteId);
			model.addAttribute("vote", voteService.getVote(voteId));
			return "answer";
		}
		else return "voteClosedError";
	}
}
