import glob
import re

vars_file_name = "app_config.properties"
patterns = [
    #"src/main/resources/templates/*.mustache",
    "src/main/webapp/WEB-INF/appengine-web.xml"
]


def read_vars_file():
    s = open(vars_file_name).readlines()
    return dict(re.split("=", e.strip(), maxsplit=1) for e in s)


unknown_vars = set()
used_vars = set()


def sub_fn(m):
    var = m.group(1)
    if var in vars:
        used_vars.add(var)
        return vars[var]
    else:
        unknown_vars.add(var)
        return "${" + var + "}"


vars = read_vars_file()
paths = [e for pattern in patterns for e in glob.glob(pattern, recursive="True")]
r = re.compile(r"\$\{([^}]*)\}")
for path in paths:
    s = open(path).read()
    sn = r.sub(sub_fn, s)
    print(path)
    print(len(path))
    print(sn)
    with open(path, "w") as fo:
        fo.write(sn)
unused_vars = vars.keys() - used_vars

print("Vars used = {}, Vars not used = {}, Unknown vars = {}".format(
    len(used_vars), len(unused_vars), len(unknown_vars)))
