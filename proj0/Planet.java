import java.lang.Math;
/** All parameters of a planet */
public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(){}
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	public Planet(Planet b){
		xxPos=b.xxPos;
		yyPos=b.yyPos;
		xxVel=b.xxVel;
		yyVel=b.yyVel;
		mass=b.mass;
		imgFileName=b.imgFileName;
	}
	/** Calculate distance between two planets */
	public double calcDistance(Planet b){
		return Math.sqrt((b.xxPos-xxPos)*(b.xxPos-xxPos)+(b.yyPos-yyPos)*(b.yyPos-yyPos));
	}
	public static final double G=6.67e-11;
	/** Calculate force exerted by planet b */
	public double calcForceExertedBy(Planet b){
		double d=this.calcDistance(b);
		return G*mass*b.mass/(d*d);
	}
	/** Calculate x-force exerted by planet b */
	public double calcForceExertedByX(Planet b){
		double d=this.calcDistance(b);
		return G*mass*b.mass/(d*d*d)*(b.xxPos-xxPos);
	}
	/** Calculate y-force exerted by planet b */
	public double calcForceExertedByY(Planet b){
		double d=this.calcDistance(b);
		return G*mass*b.mass/(d*d*d)*(b.yyPos-yyPos);
	}
	/** Calculate x-force exerted by planet array b */
	public double calcNetForceExertedByX(Planet[] b){
		double sum=0;
		for(int i=0;i<b.length;i++){
			if(this.equals(b[i])) continue;
			sum+=this.calcForceExertedByX(b[i]);
		}
		return sum;
	}
	/** Calculate y-force exerted by planet array b */
	public double calcNetForceExertedByY(Planet[] b){
		double sum=0;
		for(int i=0;i<b.length;i++){
			if(this.equals(b[i])) continue;
			sum+=this.calcForceExertedByY(b[i]);
		}
		return sum;
	}
	/** Update the planet status after a small time */
	public void update(double dt,double fX,double fY){
		this.xxVel+=dt*fX/this.mass;
		this.yyVel+=dt*fY/this.mass;
		this.xxPos+=dt*this.xxVel;
		this.yyPos+=dt*this.yyVel;
	}
}