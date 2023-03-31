package com.jcm.movimento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

	private int coinFivecents;
	private int coinTencents;
	private int coinTwentyfivecents;
	private int coinFifitycents;
	private int coinOne;
	private int ballotTwo;
	private int ballotFive;
	private int ballotTen;
	private int ballotTwenty;
	private int ballotFifity;
	private int ballotOnehundred;
	private int ballotTwohundred;
	private double totalCoins;
	private double totalBallots;

}
