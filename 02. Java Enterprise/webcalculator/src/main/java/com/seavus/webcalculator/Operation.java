package com.seavus.webcalculator;

public class Operation {

	private int operand1;
	private int operand2;
	private int result;
	private Operator operator;

	public Operation(int operand1, int operand2, Operator operator) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;
		if (operator == Operator.ADD) {
			result = operand1 + operand2;
		} else if (operator == Operator.SUBTRACT) {
			result = operand1 - operand2;
		}
	}

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		if (operator == Operator.ADD) {
			return operand1 + " + " + operand2 + " = " + result;
		} else if (operator == Operator.SUBTRACT) {
			return operand1 + " - " + operand2 + " = " + result;
		}
		return "";
	}

}
