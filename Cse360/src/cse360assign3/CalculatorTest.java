package cse360assign3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test//Testing that a object is created with the constructor
	public void testCalculator() 
	{
		Calculator constructor = new Calculator();
		assertNotNull (constructor);
	}


	@Test//Testing that the total is returned
	public void getTotalTest()
	{	
		Calculator getTotal = new Calculator();
		assertEquals(0,getTotal.getTotal());
	}
	
	@Test//Testing that the add method is working and gettotal method is returning right value 
	public void addTest()
	{	
		Calculator add = new Calculator();
		add.add(4);
		assertEquals(4,add.getTotal());
	}
	
	@Test //Testing to make sure subtract method is working as described in the assignment and returning a negitive value when it needs to
	public void subtractTest()
	{
		Calculator sub = new Calculator();
		sub.subtract(5);
		sub.subtract(5);
		sub.subtract(5);
		sub.subtract(3);
		assertEquals(-2,sub.getTotal());

	}
	
	@Test //testing add method and multiply method are working properly 
	public void multiplytest()
	{
		Calculator mult = new Calculator();
		mult.add(5);
		mult.multiply(5);
		assertEquals(25,mult.getTotal());

	}

	@Test //Testing that 0 is returned for total when value is set to zero to divide by
	public void divideTest1()
	{
		Calculator div1 = new Calculator();
		div1.divide(0);
		div1.divide(0);
		assertEquals(0,div1.getTotal());

	}
	@Test //Testing that the divide method is doing integer division .
	public void divideTest2()
	{
		Calculator div2 = new Calculator();
		div2.add(25);
		div2.divide(5);
		assertEquals(5,div2.getTotal());
	}
	
	@Test //Testing that the get history method is returning the string values correctly for each method called
	public void getHistoryTest()
	{
		Calculator Hist = new Calculator();
		Hist.add(4);
		Hist.subtract(2);
		Hist.multiply(5);
		Hist.divide(0);
		Hist.divide(5);
		assertEquals(" 0 + 4 - 2 * 5 / 0 / 5 ",Hist.getHistory());
		
		
	}

}