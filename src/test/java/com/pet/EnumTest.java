package com.pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pet.test.CalcType;
import com.pet.test.NewPayType;
import com.pet.test.PayMethod;
import com.pet.test.PayType;
import com.pet.test.Status;

public class EnumTest {
	
	@Test
	void pay테스트2() {
		// given
		PayMethod payMethod = PayMethod.CREDIT;
		
		// when
		NewPayType payType = NewPayType.findByPayMethod(payMethod);
		
		// then
		assertEquals(NewPayType.CARD, payType);
		assertEquals("신용카드", payMethod.getTitle());
	}
	
	// @Test
	void pay테스트1() {
		// given
		String payMethod = "KAKAO";
		
		// when
		// 결제 수단(예:카카오페이)에 대한 결제 종류(예:현금 또는 카드)가 무엇인가?
		PayType payType = PayType.findByPayMethod(payMethod);
		
		// then
		assertEquals(PayType.CARD, payType);
	}
	
	// @Test
	void 계산테스트() {
		// given
		CalcType calcType = CalcType.CALC_C;
		
		// when
		int result = calcType.calculate(500);
		
		// then
		assertEquals(result, 1500);
	}

	Status getStatus() {
		return Status.Y;
	}
	
	// @Test
	void Status테스트() {
		// given - 준비
		Status status = getStatus(); // Y
		
		// when - 실행
		int v1 = status.getValue1();
		boolean v2 = status.isValue2(); // 필드의 타입이 boolean이면 get이 아닌 is
		
		// then - 검증
		assertEquals(v1, 1);
		assertEquals(v2, true);
		assertEquals(status, Status.Y);
	}
}
