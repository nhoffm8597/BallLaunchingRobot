package org.usfirst.frc.team2849.robot.commands;

import edu.wpi.first.wpilibj.Spark;

public class Wheel implements Runnable {
	
	private Spark Wheel;

	@SuppressWarnings("deprecation")
	
	private Boolean running = new Boolean(false);
	
	Wheel(int channel) {
		Wheel = new Spark(channel);
		startWheel();
	}
	
	public void startWheel() {
		synchronized(running) {
			if (running) {
				return;
			}
			running = true;
		}
	}
	
	public void run() {
		while (running) {
			Wheel.set(1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Thread(this, "wheelThread").start();
		}
	}
	
	public void stop() {
		Wheel.set(0);
	}
	
	public boolean getRunning() {
		return running;
	}
	
}


