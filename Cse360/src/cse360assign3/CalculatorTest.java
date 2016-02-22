package cse360assign3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCalculator() 
	{
		Calculator constructor = new Calculator();
		assertNotNull (constructor);
	}


	@Test
	public void getTotalTest()
	{	
		Calculator getTotal = new Calculator();
		assertEquals(0,getTotal.getTotal());
	}
	
	@Test 
	public void addTest()
	{	
		Calculator add = new Calculator();
		add.add(4);
		assertEquals(4,add.getTotal());
	}
	
	@Test
	public void subtractTest()
	{
		Calculator sub = new Calculator();
		sub.subtract(5);
		assertEquals(-5,sub.getTotal());

	}
	
	@Test
	public void multiplytest()
	{
		Calculator mult = new Calculator();
		mult.add(5);
		mult.multiply(5);
		assertEquals(25,mult.getTotal());

	}

	@Test
	public void divideTest1()
	{
		Calculator div1 = new Calculator();
		div1.divide(0);
		div1.divide(0);
		assertEquals(0,div1.getTotal());

	}
	
	public void divideTest2()
	{
		Calculator div2 = new Calculator();
		div2.add(25);
		div2.divide(5);
		assertEquals(5,div2.getTotal());
	}
	
	@Test
	public void getHistoryTest()
	{
		fail ("Not yet implemented");
	}

}