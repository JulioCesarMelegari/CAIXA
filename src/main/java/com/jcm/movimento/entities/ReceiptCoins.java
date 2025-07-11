package com.jcm.movimento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "tb_recebimentos")
public class ReceiptCoins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECEBIMENTO_ID")
	private Integer id;
	
	@NotBlank(message = "preencha com valor o campo em branco")
	private int coinFivecents;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int coinTencents;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int coinTwentyfivecents;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int coinFifitycents;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int coinOne;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int ballotTwo;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int ballotFive;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int ballotTen;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int ballotTwenty;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int ballotFifity;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int ballotOnehundred;
	@NotBlank(message = "preencha com valor o campo em branco")
	private int ballotTwohundred;
	@NotBlank(message = "preencha com valor o campo em branco")
	private double totalCoins;
	@NotBlank(message = "preencha com valor o campo em branco")
	private double totalBallots;

}
