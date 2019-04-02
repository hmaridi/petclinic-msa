
package org.springframework.samples.petclinic.vets.system;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "vets")
public class VetsProperties {

	private Cache cache;

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	@Data
	public static class Cache {

		private int ttl;

		private int heapSize;

		public int getTtl() {
			return ttl;
		}

		public void setTtl(int ttl) {
			this.ttl = ttl;
		}

		public int getHeapSize() {
			return heapSize;
		}

		public void setHeapSize(int heapSize) {
			this.heapSize = heapSize;
		}

	}

}
