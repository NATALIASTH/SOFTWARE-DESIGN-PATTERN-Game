
import java.util.Scanner;

import FactoryMethod.BossFuego;
import FactoryMethod.BossHielo;
import FactoryMethod.BossNormal;
import FactoryMethod.FabricaFuego;
import FactoryMethod.FabricaHielo;
import FactoryMethod.FabricaNormal;
import FactoryMethod.TrollFuego;
import FactoryMethod.TrollHielo;
import FactoryMethod.TrollNormal;
import FactoryMethod.ZombieFuego;
import FactoryMethod.ZombieHielo;
import FactoryMethod.ZombieNormal;
import State.EstadoFuerte;

public class main {

	public static void main(String[] args) {
		
		Jugador jugador=new Jugador(100,10);
		
		FabricaNormal fabricanormal= new FabricaNormal();
		
		ZombieNormal zombie =(ZombieNormal) fabricanormal.crearZombie();
		TrollNormal troll =(TrollNormal) fabricanormal.crearTroll();
		BossNormal boss=(BossNormal)fabricanormal.crearBoss();
		
		FabricaHielo fabricahielo=new FabricaHielo();
		
		ZombieHielo zombieHielo=(ZombieHielo) fabricahielo.crearZombie();
		TrollHielo trollHielo=(TrollHielo) fabricahielo.crearTroll();
		BossHielo bossHielo=(BossHielo) fabricahielo.crearBoss();
		
		FabricaFuego fabricafuego=new FabricaFuego();
		
		ZombieFuego zombieFuego=(ZombieFuego) fabricafuego.crearZombie();
		TrollFuego trollFuego=(TrollFuego) fabricafuego.crearTroll();
		BossFuego bossFuego=(BossFuego) fabricafuego.crearBoss();
		
		Batalla batalla1 = new Batalla();
		Calculador punts=Calculador.instance();
		int flag = 1;
		int vidaTotal = 100;
		Scanner sc = new Scanner(System.in);
		
		while(flag != 0) {
			
			System.out.println("Has entrado en el primer mundo:");
			System.out.println("");
			System.out.println("Te enfrentas contra un zombie:");
			flag = batalla1.batalla(jugador, zombie,punts);
			
			if(flag==1){
			System.out.println("Te enfrentas contra un troll:");
			flag = batalla1.batalla(jugador, troll, punts);
			
			System.out.println("");
			}if(flag == 1) {
			System.out.println("El troll desprendio una piedra de vida que te sumo 45 de vida.");
			jugador.setVida(jugador.getVida() + 45);
			System.out.println("");
			
			System.out.println("Te enfrentas contra un boss:");
			flag = batalla1.batalla(jugador, boss, punts);
			}if(flag == 1) {
			System.out.println("Has pasado de mundo.");
			System.out.println("");
			jugador.setVida(vidaTotal);
			jugador.setState(new EstadoFuerte(3)); // recupera la vida al terminar el primer mundo y el estado
			System.out.println("Enorabueno al superar el primer mundo desbloqueas una de estas dos ventajas 1) 5 de daño extra 2) 20 de vida extra:");
			int decision = sc.nextInt();
			if(decision == 1)
				jugador.setDanio(jugador.getDanio() + 5);
			else { jugador.setVida(jugador.getVida() + 20);
					vidaTotal += 20;
			}
				System.out.println("");
				System.out.println("Has entrado en el segundo mundo:");
				
				System.out.println("Te enfrentas contra un zombie de hielo");
				flag = batalla1.batalla(jugador, zombieHielo,punts);
				
			}if(flag == 1) {
				System.out.println("Te enfrentas contra un troll de hielo");
				flag = batalla1.batalla(jugador, trollHielo, punts);
			}if(flag == 1) {
				System.out.println("");
				System.out.println("El troll desprendio una piedra de vida que te sumo 45 de vida");
				jugador.setVida(jugador.getVida() + 45);
				
				
				System.out.println("Te enfrentas contra un boss de hielo");
				flag = batalla1.batalla(jugador, bossHielo, punts);
			}if(flag == 1) {
				System.out.println("Has pasado de mundo");
				jugador.setVida(vidaTotal); // recupera la vida al terminar el primer mundo y el estado
				jugador.setState(new EstadoFuerte(3));
				System.out.println("Enorabueno al superar el segundo mundo desbloqueas una de estas dos ventajas \"1\" 5 de daño extra \"2\" 20 de vida extra");
				int decision2 = sc.nextInt();
				if(decision2 == 1)
					jugador.setDanio(jugador.getDanio() + 5);
				else { 
					jugador.setVida(jugador.getVida() + 20);
					vidaTotal += 20;	
				}
				
				System.out.println("Has entrado en el tercer mundo:");
							
				System.out.println("Te enfrentas contra un zombie de fuego");
				flag = batalla1.batalla(jugador, zombieFuego,punts);
			}if(flag == 1) {
				System.out.println("Te enfrentas contra un troll de fuego");
				flag = batalla1.batalla(jugador, trollFuego, punts);
			}if(flag == 1) {
				System.out.println("El troll desprendio una piedra de vida que te sumo 45 de vida");
				jugador.setVida(jugador.getVida() + 45);
				System.out.println(jugador.getVida());
				
				System.out.println("Te enfrentas contra un boss de fuego");
				flag = batalla1.batalla(jugador, bossFuego, punts);
			}if(flag == 1) {
				System.out.println("Has pasado el ultimo mundo");
	
				System.out.println("Enorabuena te has pasado el juego");
				flag = 0;
			}
		}
		sc.close();
	}
}


