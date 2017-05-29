
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.ShoppingGroup;

@Component
@Transactional
public class ShoppingGroupToStringConverter implements Converter<ShoppingGroup, String> {

	@Override
	public String convert(final ShoppingGroup source) {
		String res;

		if (source == null)
			res = null;
		else
			res = String.valueOf(source.getId());

		return res;
	}

}
