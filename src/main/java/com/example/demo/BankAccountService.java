package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public BankAccount createBangkAccount(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}

	public Optional<BankAccount> getBankAccountById(int id) {
		return bankAccountRepository.findById(id);
	}

	public List<BankAccount> getAllBankAccounts() {
		return (List<BankAccount>) bankAccountRepository.findAll();
	}

}
