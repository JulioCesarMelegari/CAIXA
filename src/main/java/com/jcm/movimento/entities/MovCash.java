package com.jcm.movimento.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "tb_movimentos")
public class MovCash {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Preencha com o Operador")
	private String operator;
	
	@NotNull(message = "preencha com a data")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateMov;
	
	@DecimalMin(value = "200", message = "Preencha com o valor inicial, minimo R$ 200,00")
	private double initialValue;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "RECEBIMENTO_ID" )
	private ReceiptCoins receiptCoins;
	

	@OneToMany(mappedBy = "movCash", targetEntity = Payment.class, fetch = FetchType.LAZY)
	private List<Payment> payments;
	
	private String observation;
	

	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDateTime date = LocalDateTime.now();
	
}
