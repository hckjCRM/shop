package servletwork;

public class EMP
{

  protected int EMPNO;
  protected String ENAME;
  protected String JOB;
  protected int MGR;
  protected String HIREDATE;
  protected double SAL;
  protected double COMM;
  protected int DEPTNO;

  public EMP()
  {
  }

  public int getEMPNO()
  {
    return EMPNO;
  }
  public void setEMPNO(int value)
  {
    this.EMPNO = value;
  }
  public String getENAME()
  {
    return ENAME;
  }
  public void setENAME(String value)
  {
    this.ENAME = value;
  }
  public String getJOB()
  {
    return JOB;
  }
  public void setJOB(String value)
  {
    this.JOB = value;
  }
  public int getMGR()
  {
    return MGR;
  }
  public void setMGR(int value)
  {
    this.MGR = value;
  }
  public String getHIREDATE()
  {
    return HIREDATE;
  }
  public void setHIREDATE(String value)
  {
    this.HIREDATE = value;
  }
  public double getSAL()
  {
    return SAL;
  }
  public void setSAL(double value)
  {
    this.SAL = value;
  }
  public double getCOMM()
  {
    return COMM;
  }
  public void setCOMM(double value)
  {
    this.COMM = value;
  }
  public int getDEPTNO()
  {
    return DEPTNO;
  }
  public void setDEPTNO(int value)
  {
    this.DEPTNO = value;
  }
}

