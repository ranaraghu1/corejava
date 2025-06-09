package test.java.thread;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

public class ProducerConsumerApplication {

	private static final int N = 5;
	private static final String INPUT_FILE = "./out/matrics/input.txt";
	private static final String OUTPUT_FILE = "./out/matrics/result.txt";

	public static void main(String[] args) throws IOException {
		ThreadSafeQueue threadSafeQueue = new ThreadSafeQueue();
		File inputFile = new File(INPUT_FILE);
		File outPutFile = new File(OUTPUT_FILE);

		MatrixReaderProducer matrixReaderProducer = new MatrixReaderProducer(new FileReader(inputFile),
				threadSafeQueue);
		
		MatrixMultiplierConsumer matrixMultiplierConsumer=new MatrixMultiplierConsumer(new FileWriter(outPutFile), threadSafeQueue);
	
		matrixReaderProducer.start();
		matrixMultiplierConsumer.start();
	}

	private static class MatrixMultiplierConsumer extends Thread {
		private ThreadSafeQueue queue;
		private FileWriter writer;

		MatrixMultiplierConsumer(FileWriter writer, ThreadSafeQueue queue) {
			this.writer = writer;
			this.queue = queue;
		}

		private float[][] multiplyMatrix(float[][] m1, float[][] m2) {

			float[][] result = new float[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int k = 0; k < N; k++) {
						result[r][c] += m1[r][k] * m2[k][c];
					}
				}

			}
			return result;

		}

		@Override
		public void run() {
			while (true) {
				MarixPair matMarixPair = queue.remove();
				if (matMarixPair == null) {
					System.out.println("No more matrics to read from queue- Consumer is terminating");
					break;
				}
				float[][] result = multiplyMatrix(matMarixPair.matrix1, matMarixPair.matix2);
				try {
					saveMatrixToFile(writer, result);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		public void saveMatrixToFile(FileWriter fileWriter, float[][] matrix) throws IOException {
			for (int r = 0; r < N; r++) {
				StringJoiner stringJoiner = new StringJoiner(", ");
				for (int c = 0; c < N; c++) {
					stringJoiner.add(String.format("%.2f", matrix[r][c]));
				}
				fileWriter.write(stringJoiner.toString());
				fileWriter.write('\n');
			}
			fileWriter.write('\n');
		}
	}

	private static class MatrixReaderProducer extends Thread {
		private Scanner scanner;
		private ThreadSafeQueue queue;

		public MatrixReaderProducer(FileReader reader, ThreadSafeQueue queue) {
			this.scanner = new Scanner(reader);
			this.queue = queue;

		}

		@Override
		public void run() {
			while (true) {
				float[][] matrix1 = readMatrix();
				float[][] matrix2 = readMatrix();
				if (matrix1 == null || matrix2 == null) {
					queue.terminate();
					System.out.println("No more matrics to read. Producer is terninating");
					return;
				}
				MarixPair matMarixPair = new MarixPair();
				matMarixPair.matrix1 = matrix1;
				matMarixPair.matix2 = matrix2;
				queue.addmatrics(matMarixPair);

			}
		}

		private float[][] readMatrix() {
			float[][] matrix = new float[N][N];
			for (int r = 0; r < N; r++) {
				if (!scanner.hasNext()) {
					return null;
				}
				String[] line = scanner.nextLine().split(",");
				for (int c = 0; c < N; c++) {
					matrix[r][c] = Float.valueOf(line[c]);
				}
			}
			scanner.nextLine();
			return matrix;
		}
	}

	private static class ThreadSafeQueue {
		private Queue<MarixPair> queue = new LinkedList();
		private boolean isEmpty = true;
		private boolean isterminate = false;

		public synchronized void addmatrics(MarixPair matrPair) {
			queue.add(matrPair);
			isEmpty = false;
			notify();
		}

		public synchronized MarixPair remove() {
			while (isEmpty && !isterminate) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (queue.size() == 1) {
				isEmpty = true;
			}

			if (queue.size() == 0 && isterminate) {
				return null;
			}

			System.out.println("Queue size::" + queue.size());
			return queue.remove();
		}

		public synchronized void terminate() {
			isterminate = true;
			notifyAll();

		}

	}

	private static class MarixPair {
		public float[][] matrix1;
		public float[][] matix2;
	}

}
