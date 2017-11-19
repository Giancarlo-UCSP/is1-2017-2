package controller;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AccountService;
import service.AlumnoService;
import service.TransferService;
import domain.Account;
import form.CreateAccountForm;
import form.TransferForm;
import domain.Alumno;
import domain.Person;

@Controller
public class BankController {

	@Autowired
	TransferService transferService;

	@Autowired
	AccountService accountService;
	
	AlumnoService alumnoService;

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	String transfer(@ModelAttribute TransferForm transfer, ModelMap model) {
		transferService.transfer(transfer.getSourceAccountNumber(), transfer.getTargetAccountNumber(), transfer.getAmount());
		return "home";
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	String showTransfer(@ModelAttribute TransferForm transfer, ModelMap model) {
		return "transfer";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	String saveAccount(@ModelAttribute Account account, ModelMap model) {
		accountService.save(account);
		return "account-list";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	String listAccounts(ModelMap model) {
		model.addAttribute("accounts", accountService.getAccounts());
		return "account-list";
	}

	@RequestMapping(value = "/add-account", method = RequestMethod.GET)
	String addAccount(ModelMap model) {
		return "add-account";
	}
	
	@RequestMapping(value = "/register-account", method = RequestMethod.POST)
	String createAccount(@ModelAttribute CreateAccountForm createAccount, ModelMap model) {
		accountService.createAccount(createAccount.getOwnerIds(), createAccount.getAccount());
		return "add-account";
	}
	
	//@RequestMapping(value = "/alumno", method = RequestMethod.GET)
	//String alumno(ModelMap model) {
		//alumnoService.getAll();
		//return "alumno";
	//}
	
	//@RequestMapping(value = "/alumno", method = RequestMethod.GET)
    //@ResponseBody
    //public String listarAlumnos() {
    //    List<Alumno> alumnos = alumnoService.getAll();
    //    return "alumno";
    //}
	
	@RequestMapping(value = "/alumno", method = RequestMethod.GET)
	String showAlumno(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			//Person person = personService.get(id);
			//model.addAttribute("person", person);
			return "alumno";
		} else {
			List<Alumno> alumnos = alumnoService.getAll();
			//Collection<Person> people = personService.getAll();
			model.addAttribute("alumno", alumnos);
			return "alumno";
		}
	}
	
	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	String curso(ModelMap model) {
		return "cursos";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(ModelMap model) {
		return "home";
	}
}
