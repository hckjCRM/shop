/**
 * EMP
 * @author User(EMAIL) 2018-11-14 09:12:14
 * @version 1.0 2018-11-14 09:12:14

EMP
-----------------------
EMPNO     PKInteger(4)
ENAME     String(10)
JOB       String(9)
MGR       Integer(4)
HIREDATE  Date
SAL       Float(7,2)
COMM      Float(7,2)
DEPTNO    FKEnum


SQLMAP:
<resultMap id="resMap_EMP"
	class="EMP.EMP">
	<result property="EMPNO" column="EMPNO" />
	<result property="ENAME" column="ENAME" />
	<result property="JOB" column="JOB" />
	<result property="MGR" column="MGR" />
	<result property="HIREDATE" column="HIREDATE" />
	<result property="SAL" column="SAL" />
	<result property="COMM" column="COMM" />
	<result property="DEPTNO" column="DEPTNO" />
</resultMap>
<select id="sel_EMP" resultMap="resMap_EMP"><![CDATA[
  select t.* from EMP t
]]></select>

*/

package huse2018.j2ee.teaching.servlet.day02.work;

import java.sql.Date;

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

