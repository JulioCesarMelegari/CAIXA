package com.jcm.movimento.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcm.movimento.entities.MovCash;
import com.jcm.movimento.entities.Operation;
import com.jcm.movimento.entities.Payment;
import com.jcm.movimento.entities.ReceiptCoins;
import com.jcm.movimento.entities.Status;
import com.jcm.movimento.services.MovService;
import com.jcm.movimento.services.PaymentService;
import com.jcm.movimento.services.ReceiptService;

import jakarta.validation.Valid;
import lombok.experimental.PackagePrivate;

@Controller
@RequestMapping("/movimento")
public class MovController {
	
	private static final String VIEW_CADASTRAR = "CadastrarMov";
	private static final String VIEW_LISTAR = "listar";
	private static final String VIEW_FECHAR = "FecharCash";
	private static final String VIEW_PAYMENT_LISTAR = "Pagamentos";
	private static final String VIEW_PAYMENT_CADASTRAR = "CadastrarPag";
	private Integer movCachLocalId;
	
	@Autowired
	private MovService movService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ReceiptService receiptService;
	
	@RequestMapping("list")
	public String index(Model model) {
		List<MovCash> listMovCash = movService.listByStatus(Status.ABERTO);
		model.addAttribute("ListMov", listMovCash);
		return VIEW_LISTAR;
	}
	
	@RequestMapping("listAll")
	public String listAll(Model model) {
		List<MovCash> listMovCash = movService.listAll();
		model.addAttribute("ListMov", listMovCash);
		return VIEW_LISTAR;
	}
	
	@RequestMapping("add")
	public ModelAndView add(MovCash movCach) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(VIEW_CADASTRAR);
		mv.addObject("mov", movCach);
		System.out.println(movCach);
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("mov") MovCash movCach, BindingResult result) {
		if(result.hasErrors()) {
			return add(movCach);
		}
		movCach.setStatus(Status.ABERTO);

		movService.save(movCach);
		System.out.println(movCach);
		ModelAndView mv = new ModelAndView("redirect:/movimento/list");
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		movService.delete(id);
		ModelAndView mv = new ModelAndView("redirect:/movimento/list");
		return mv;
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id")Integer id) {
		return add(movService.getById(id));
	}
	
	@RequestMapping(value="/fechament/{id}" )
	public ModelAndView fechar(@PathVariable("id") Integer id) {
		//MovCash mov =  movService.getById(id);
		this.movCachLocalId = id;
		ReceiptCoins recbCash = new ReceiptCoins();
		ModelAndView mv = new ModelAndView();
		mv.setViewName(VIEW_FECHAR);
		mv.addObject("recebCash", recbCash);

		return mv;

	}
	
	@RequestMapping(value = "/fechament/{id}", method = RequestMethod.POST)
	public ModelAndView FechaMov(@Valid @ModelAttribute("recebCash") ReceiptCoins recbCash, BindingResult result) {
	
		receiptService.save(recbCash);
		MovCash mov = movService.getById(this.movCachLocalId);
		mov.setReceiptCoins(recbCash);
		mov.setStatus(Status.FECHADO);
		movService.save(mov);
		System.out.println(mov);
		System.out.println(recbCash);
		
		ModelAndView mv = new ModelAndView("redirect:/movimento/list");
		return mv;
	}
	
	
	@RequestMapping("/payments")
	public ModelAndView payments() {
		Operation[] operation = Operation.values();
		Payment payment = new Payment();
		ModelAndView mv = new ModelAndView();
		mv.setViewName(VIEW_PAYMENT_CADASTRAR);
		mv.addObject("payment", payment);
		mv.addObject("operations", operation);
		return mv;
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ModelAndView cadPayment(@Valid @ModelAttribute("payment") Payment payment, BindingResult result) {
		MovCash mov = movService.getById(movCachLocalId);

		payment.setMovCash(mov);
		paymentService.save(payment);
		System.out.println(payment);
		ModelAndView mv = new ModelAndView("redirect:/movimento/ListarPagamentos");
		return mv;
	}
	
	@RequestMapping("ListarPagamentos")
	public String payments(Model model) {
		MovCash mov = movService.getById(movCachLocalId);
		List<Payment> listPayments = paymentService.listByMov(mov);
		model.addAttribute("ListPayments", listPayments);
		return VIEW_PAYMENT_LISTAR;
	}
	

}
