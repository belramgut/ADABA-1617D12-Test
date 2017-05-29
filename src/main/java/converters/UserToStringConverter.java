
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.User;

@Component
@Transactional
public class UserToStringConverter implements Converter<User, String> {

	@Override
	public String convert(final User source) {
		String res;

		if (source == null)
			res = null;
		else
			res = String.valueOf(source.getId());

		return res;
	}

}
