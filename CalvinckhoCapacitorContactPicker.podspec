
  Pod::Spec.new do |s|
    s.name = 'CalvinckhoCapacitorContactPicker'
    s.version = '1.0.0'
    s.summary = 'Allows users to select one or many contacts from their device.'
    s.license = 'MIT'
    s.homepage = 'https://github.com/calvinckho/capacitor-contact-picker'
    s.author = 'Sean Perkins'
    s.source = { :git => 'https://github.com/calvinckho/capacitor-contact-picker', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '13.0'
    s.swift_version = '5.1'
    s.dependency 'Capacitor'
  end
