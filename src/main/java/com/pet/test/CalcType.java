package com.pet.test;

import java.util.function.Function;

public enum CalcType {
	// 열거형 정의
	CALC_A(value -> value), // 람다식(최신문법) -> 낮은 버전에선 안돌아감
	CALC_B(value -> value * 10),
	CALC_C(value -> value * 3),
	CALC_ETC(value -> 0);
	
	// 필드 정의
	private Function<Integer, Integer> expression;
	
	// 생성자
	CalcType(Function<Integer, Integer> expression) {
		this.expression = expression;
	}
	
	// 계산 적용 메소드
	public int calculate(int value) {
		return expression.apply(value);
	}
}
