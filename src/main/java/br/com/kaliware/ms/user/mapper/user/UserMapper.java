package br.com.kaliware.ms.user.mapper.user;


import br.com.kaliware.ms.user.config.mapper.MapperConfiguration;
import br.com.kaliware.ms.user.entity.user.User;
import br.com.kaliware.ms.user.record.user.UserRecord;
import br.com.kaliware.ms.user.service.bcrypt.PasswordEncoder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class, uses = {PasswordEncoder.class})
public interface UserMapper {

  @Mapping(target = "password", ignore = true)
  UserRecord entityToRecord(User entity);

  @Mapping(target = "password", qualifiedByName = "encode",source = "password")
  User recordToEntity(UserRecord record);
}
