/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.yamlutilities;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to convert Yaml to properties
 * form so that it can be used in {@link PropertySource } annotation
 * 
 * @author Rudhra Koul
 * @since 22 Jul 2019
 * @version 1.0
 */
public class BahiKhataYamlToPropertySourceFactory implements PropertySourceFactory {
	@Override
	public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
		Properties loadedProperties = this.loadYamlIntoProperties(resource.getResource());

		return new PropertiesPropertySource(
				(StringUtils.isNotBlank(name)) ? name : resource.getResource().getFilename(), loadedProperties);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method loads yml into {@link Properties}
	 * 
	 * @since 22 Jul 2019
	 * @param resource
	 * @return
	 */
	private Properties loadYamlIntoProperties(Resource resource) {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(resource);
		factory.afterPropertiesSet();

		return factory.getObject();
	}
}